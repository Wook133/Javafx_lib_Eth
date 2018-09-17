package sample;
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
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.CompletableFuture;
public class deployContracts {
    private static final Logger log = LoggerFactory.getLogger(deployContracts.class);
    public static void main(String[] args) throws Exception {
        new deployContracts().run();
    }

    private void run() throws Exception {
        Web3j web3j = Web3j.build(new HttpService());
        System.out.println("Connected to Ethereum client version: " +  web3j.web3ClientVersion().send().getWeb3ClientVersion().toString());
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "123456789",
                        "W://ETH_TEST_NET//chaindata//keystore//UTC--2018-09-16T12-55-19.150022300Z--e9c2a56b8a3a29c8c85960bb0037b786e5b85e56");
        System.out.println("Credentials loaded");
        System.out.println("Deploying smart contract");
        HelloWorld_sol_HelloWorld contract = HelloWorld_sol_HelloWorld.deploy(
                web3j, credentials,
                ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
        String contractAddress = contract.getContractAddress();
        System.out.println("Smart contract deployed to address " + contractAddress);

        P3AbsoluteBasic_sol_CowOwnerInfo contract1 = P3AbsoluteBasic_sol_CowOwnerInfo.deploy(
                web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT, new BigInteger("100000"), "0xE9C2A56b8A3a29C8c85960Bb0037B786e5B85e56", "InfoTemp"
        ).send();
        String contractAddress1 = contract1.getContractAddress();
        System.out.println("Smart contract P3AbsoluteBasic_sol_CowOwnerInfo 1 deployed to address " + contractAddress1);


        P3AbsoluteBasic_sol_lifeInformation contract2 = P3AbsoluteBasic_sol_lifeInformation.deploy(
                web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT, new BigInteger("100000")
        ).send();


        String contractAddress2 = contract2.getContractAddress();
        System.out.println("Smart contract P3AbsoluteBasic_sol_lifeInformation 2 deployed to address " + contractAddress2);




    }

}
