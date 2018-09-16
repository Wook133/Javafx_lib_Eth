import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.codegen.SolidityFunctionWrapperGenerator;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import sample.HelloWorld_sol_HelloWorld;

import java.io.File;
import java.math.BigDecimal;
import java.util.concurrent.CompletableFuture;

public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        //WalletUtils.generateNewWalletFile("PASSWORD", new File("W://University//dapp_java//res"), true);
        //Credentials credentials = WalletUtils.loadCredentials("PASSWORD", "W://University//dapp_java//res");
        new Application().run();
    }

    private void run() throws Exception {
        // We start by creating a new web3j instance to connect to remote nodes on the network.
        Web3j web3j = Web3j.build(new HttpService());
        System.out.println("Connected to Ethereum client version: " +  web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());

        /*log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());*/
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "123456789",
                        "W://ETH_TEST_NET//chaindata//keystore//UTC--2018-09-16T12-55-19.150022300Z--e9c2a56b8a3a29c8c85960bb0037b786e5b85e56");
        System.out.println("Credentials loaded");
        System.out.println("Sending Ether ..");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j, credentials,
                "0x98377eaC0a49605ce37Aa348af5bB0E0dc4987b9",  // you can put any address here
                BigDecimal.valueOf(86), Convert.Unit.ETHER)  // 1 wei = 10^-18 Ether
                .sendAsync().get();
        System.out.println("Transaction complete : " + transferReceipt.getTransactionHash());


        // Now lets deploy a smart contract

        System.out.println("Deploying smart contract");
        HelloWorld_sol_HelloWorld contract = HelloWorld_sol_HelloWorld.deploy(
                web3j, credentials,
                ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();

        String contractAddress = contract.getContractAddress();

        System.out.println("Smart contract deployed to address " + contractAddress);

        System.out.println("Initial value of counter in Smart contract: " + contract.getCounter().send());
        System.out.println("Incrementing counter in Smart contract");
        contract.add().send();
        System.out.println("Value of counter in Smart contract after increment : " + contract.getCounter().send());
        System.out.println("Decrementing counter in Smart contract");
        contract.subtract().send();
        System.out.println("Final value of counter in Smart contract : " + contract.getCounter().send());

    }
    // We start by creating a new web3j instance to connect to remote nodes on the network.
       /* Web3j web3j = Web3j.build(new HttpService());
        log.info("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        getEthBalance();
        //Credentials credentials = Credentials.create("bench patch approve organ reform bag syrup cash exclude agent avoid street", "0xCE2Ab584F271c6e89BB9eC7c78831aCc64E91baB");
        //WalletUtils.generateNewWalletFile("PASSWORD", new File("/res"), true);

        Credentials credentials =
                WalletUtils.loadCredentials(
                        "PASSWORD",
                        "W://University//dapp_java//res//UTC--2018-09-15T20-48-28.506832200Z--3b857c2dd7d007b210fb82312f31eedb258c9fea.json");
        log.info("Credentials loaded");
        log.info("Sending Ether ..");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j, credentials,
                "0xDc1Fb60F7E1eF6ef052A014EFbDF82debd803D06",  // you can put any address here
                BigDecimal.valueOf(100), Convert.Unit.ETHER)  // 1 wei = 10^-18 Ether
                .sendAsync().get();
        log.info("Transaction complete : "
                + transferReceipt.getTransactionHash());


        // Now lets deploy a smart contract
        log.info("Deploying smart contract");
        HelloWorld_sol_HelloWorld contract = HelloWorld_sol_HelloWorld.deploy(
                web3j, credentials,
                ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();

        String contractAddress = contract.getContractAddress();
        log.info("Smart contract deployed to address " + contractAddress);

        log.info("Initial value of counter in Smart contract: " + contract.getCounter().send());
        log.info("Incrementing counter in Smart contract");
        contract.add().send();
        log.info("Value of counter in Smart contract after increment : " + contract.getCounter().send());
        log.info("Decrementing counter in Smart contract");
        contract.subtract().send();
        log.info("Final value of counter in Smart contract : " + contract.getCounter().send());*/



    // System.out.println(getEthBalance().toString());
        /*Credentials crd = WalletUtils.
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "supersafepassword",
                        "chaindata\\keystore\\UTC--2018--<rest of the file name>");
        log.info("Credentials loaded");
        log.info("Sending Ether ..");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j, credentials,
                "0xf900D5fEEf974F058543E47B27C801D396684266",  // you can put any address here
                BigDecimal.valueOf(100), Convert.Unit.ETHER)  // 1 wei = 10^-18 Ether
                .sendAsync().get();
        log.info("Transaction complete : "
                + transferReceipt.getTransactionHash());*/


    public CompletableFuture<EthBlockNumber> getBlockNumber() throws Exception
    {
        Web3j web3j = Web3j.build(new HttpService());

        EthBlockNumber result = new EthBlockNumber();
        result = web3j.ethBlockNumber()
                .sendAsync().get();
        return CompletableFuture.completedFuture(result);
    }
    public CompletableFuture<EthAccounts> getEthAccounts() throws Exception
    {
        EthAccounts result = new EthAccounts();
        Web3j web3j = Web3j.build(new HttpService());
        result = web3j.ethAccounts()
                .sendAsync()
                .get();
        return CompletableFuture.completedFuture(result);
    }

    public CompletableFuture<EthGetBalance> getEthBalance() throws Exception {
        EthGetBalance result = new EthGetBalance();
        Web3j web3j = Web3j.build(new HttpService());
        web3j.ethCompileSolidity("[{\"constant\":false,\"inputs\":[{\"name\":\"data\",\"type\":\"uint256\"}],\"name\":\"set\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"get\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"}]");

        result = web3j.ethGetBalance("0xCE2Ab584F271c6e89BB9eC7c78831aCc64E91baB",
                DefaultBlockParameter.valueOf("latest"))
                .sendAsync()
                .get();
        System.out.println("Wei= " + result.getBalance());
        return CompletableFuture.completedFuture(result);
    }

    public void test()
    {

    }




}

