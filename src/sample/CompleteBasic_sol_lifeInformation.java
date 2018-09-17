package sample;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint16;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class CompleteBasic_sol_lifeInformation extends Contract {
    private static final String BINARY = "60806040526000805460a060020a61ffff0219600160a060020a031990911633171690556002805461ffff19169055610a888061003d6000396000f3006080604052600436106100b95763ffffffff7c010000000000000000000000000000000000000000000000000000000060003504166301a2175781146100be5780634a5ddb6a146101845780635f3b1f3b146101bc578063610be654146101df5780637cab5e8c146101f45780637de4626514610215578063a80d766a14610231578063b02ec52f1461024d578063ba5ccc63146102b4578063cb44211e14610345578063d6aa91d114610366578063dc5cb28314610392575b600080fd5b3480156100ca57600080fd5b506100da61ffff600435166103a7565b6040518084600160a060020a0316600160a060020a0316815260200183600160a060020a0316600160a060020a0316815260200180602001828103825283818151815260200191508051906020019080838360005b8381101561014757818101518382015260200161012f565b50505050905090810190601f1680156101745780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b34801561019057600080fd5b506101a061ffff600435166104cc565b60408051600160a060020a039092168252519081900360200190f35b3480156101c857600080fd5b506101dd600160a060020a0360043516610548565b005b3480156101eb57600080fd5b506101dd6105d1565b34801561020057600080fd5b506101dd600160a060020a03600435166105f6565b34801561022157600080fd5b506101a061ffff6004351661062e565b34801561023d57600080fd5b506101a061ffff600435166106a2565b34801561025957600080fd5b5060408051602060046024803582810135601f81018590048502860185019096528585526101dd958335600160a060020a031695369560449491939091019190819084018382808284375094975061071b9650505050505050565b3480156102c057600080fd5b506102d061ffff60043516610847565b6040805160208082528351818301528351919283929083019185019080838360005b8381101561030a5781810151838201526020016102f2565b50505050905090810190601f1680156103375780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561035157600080fd5b506101dd600160a060020a036004351661094a565b34801561037257600080fd5b5061037b610988565b6040805161ffff9092168252519081900360200190f35b34801561039e57600080fd5b5061037b610993565b60008054819060609061ffff8086169160a060020a900416811115610404576040805160e560020a62461bcd02815260206004820152600c6024820152600080516020610a3d833981519152604482015290519081900360640190fd5b61ffff851660009081526004602090815260409182902080546001808301546002938401805487516101009482161594909402600019011694909404601f8101869004860283018601909652858252600160a060020a0392831695921693909183918301828280156104b75780601f1061048c576101008083540402835291602001916104b7565b820191906000526020600020905b81548152906001019060200180831161049a57829003601f168201915b50505050509050935093509350509193909250565b6000805461ffff8084169160a060020a900416811115610524576040805160e560020a62461bcd02815260206004820152600c6024820152600080516020610a3d833981519152604482015290519081900360640190fd5b505061ffff16600090815260046020526040902060010154600160a060020a031690565b600054600160a060020a0316331461055f57600080fd5b6002805461ffff9081166000908152600360209081526040808320805473ffffffffffffffffffffffffffffffffffffffff1916600160a060020a03979097169687179055845461ffff198116908516600190810190951617909455938152928190529120805460ff19169091179055565b600054600160a060020a031633146105e857600080fd5b600054600160a060020a0316ff5b600054600160a060020a0316331461060d57600080fd5b600160a060020a03166000908152600160205260409020805460ff19169055565b60025460009061ffff8084169116811115610681576040805160e560020a62461bcd02815260206004820152600c6024820152600080516020610a3d833981519152604482015290519081900360640190fd5b505061ffff16600090815260036020526040902054600160a060020a031690565b6000805461ffff8084169160a060020a9004168111156106fa576040805160e560020a62461bcd02815260206004820152600c6024820152600080516020610a3d833981519152604482015290519081900360640190fd5b505061ffff16600090815260046020526040902054600160a060020a031690565b3360008181526001602081905260409091205460ff16151514610788576040805160e560020a62461bcd02815260206004820152600c60248201527f4e6f7420617070726f7665640000000000000000000000000000000000000000604482015290519081900360640190fd5b6000805461ffff60a060020a91829004811683526004602090815260408085208054600160a060020a038a1673ffffffffffffffffffffffffffffffffffffffff199182161790915585548590048416865281862060010180549091163317905584549390930490911683529120835161080a926002909201918501906109a4565b505060008054600161ffff60a060020a808404821692909201160275ffff0000000000000000000000000000000000000000199091161790555050565b60005460609061ffff8084169160a060020a9004168111156108a1576040805160e560020a62461bcd02815260206004820152600c6024820152600080516020610a3d833981519152604482015290519081900360640190fd5b61ffff83166000908152600460209081526040918290206002908101805484516001821615610100026000190190911692909204601f81018490048402830184019094528382529092909183018282801561093d5780601f106109125761010080835404028352916020019161093d565b820191906000526020600020905b81548152906001019060200180831161092057829003601f168201915b5050505050915050919050565b600054600160a060020a0316331461096157600080fd5b600160a060020a03166000908152600160208190526040909120805460ff19169091179055565b60025461ffff165b90565b60005460a060020a900461ffff1690565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106109e557805160ff1916838001178555610a12565b82800160010185558215610a12579182015b82811115610a125782518255916020019190600101906109f7565b50610a1e929150610a22565b5090565b61099091905b80821115610a1e5760008155600101610a2856004f7574206f6620496e6465780000000000000000000000000000000000000000a165627a7a72305820c96f468cbcc06542ebce14291a1fc0aef4da85eb4143fe408db09c53476b90b40029";

    public static final String FUNC_GETPOS = "getPos";

    public static final String FUNC_GETPUBLISHERPOS = "getPublisherPos";

    public static final String FUNC_ADDOWNERS = "addOwners";

    public static final String FUNC_CLOSECONTRACT = "closeContract";

    public static final String FUNC_REMOVEAPPROVAL = "removeApproval";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_GETCOWADDRESSPOS = "getCowAddressPos";

    public static final String FUNC_ADDINFORMATION = "addInformation";

    public static final String FUNC_GETINFORMATIONPOS = "getInformationPos";

    public static final String FUNC_ADDAPPROVAL = "addApproval";

    public static final String FUNC_GETCOUNTOWNERS = "getCountOwners";

    public static final String FUNC_GETCOUNTCOWS = "getCountCows";

    protected CompleteBasic_sol_lifeInformation(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CompleteBasic_sol_lifeInformation(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<Tuple3<String, String, String>> getPos(BigInteger index) {
        final Function function = new Function(FUNC_GETPOS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple3<String, String, String>>(
                new Callable<Tuple3<String, String, String>>() {
                    @Override
                    public Tuple3<String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<String> getPublisherPos(BigInteger index) {
        final Function function = new Function(FUNC_GETPUBLISHERPOS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addOwners(String s) {
        final Function function = new Function(
                FUNC_ADDOWNERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> closeContract() {
        final Function function = new Function(
                FUNC_CLOSECONTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> removeApproval(String s) {
        final Function function = new Function(
                FUNC_REMOVEAPPROVAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getOwner(BigInteger index) {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getCowAddressPos(BigInteger index) {
        final Function function = new Function(FUNC_GETCOWADDRESSPOS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addInformation(String a, String b) {
        final Function function = new Function(
                FUNC_ADDINFORMATION, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(a), 
                new org.web3j.abi.datatypes.Utf8String(b)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getInformationPos(BigInteger index) {
        final Function function = new Function(FUNC_GETINFORMATIONPOS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint16(index)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addApproval(String s) {
        final Function function = new Function(
                FUNC_ADDAPPROVAL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getCountOwners() {
        final Function function = new Function(FUNC_GETCOUNTOWNERS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getCountCows() {
        final Function function = new Function(FUNC_GETCOUNTCOWS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint16>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<CompleteBasic_sol_lifeInformation> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(CompleteBasic_sol_lifeInformation.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static RemoteCall<CompleteBasic_sol_lifeInformation> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployRemoteCall(CompleteBasic_sol_lifeInformation.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static CompleteBasic_sol_lifeInformation load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CompleteBasic_sol_lifeInformation(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static CompleteBasic_sol_lifeInformation load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CompleteBasic_sol_lifeInformation(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
