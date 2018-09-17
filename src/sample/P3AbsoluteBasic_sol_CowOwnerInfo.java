package sample;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
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
public class P3AbsoluteBasic_sol_CowOwnerInfo extends Contract {
    private static final String BINARY = "60806040526040516105ea3803806105ea83398101604052805160208083015160008054600160a060020a038516600160a060020a03199182161790915560018054909116331790559092018051919290916100619160029190840190610069565b505050610104565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100aa57805160ff19168380011785556100d7565b828001600101855582156100d7579182015b828111156100d75782518255916020019190600101906100bc565b506100e39291506100e7565b5090565b61010191905b808211156100e357600081556001016100ed565b90565b6104d7806101136000396000f30060806040526004361061008d5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416635a9b0b8981146100925780635f8988b51461011c578063610be6541461014d578063893d20e8146101645780638da5cb5b14610179578063c0da1e681461018e578063dfbf306d1461024d578063f47b774014610262575b600080fd5b34801561009e57600080fd5b506100a7610277565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100e15781810151838201526020016100c9565b50505050905090810190601f16801561010e5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561012857600080fd5b5061013161030a565b60408051600160a060020a039092168252519081900360200190f35b34801561015957600080fd5b50610162610319565b005b34801561017057600080fd5b5061013161033c565b34801561018557600080fd5b5061013161034b565b34801561019a57600080fd5b506101a361035a565b6040518084600160a060020a0316600160a060020a0316815260200183600160a060020a0316600160a060020a0316815260200180602001828103825283818151815260200191508051906020019080838360005b838110156102105781810151838201526020016101f8565b50505050905090810190601f16801561023d5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b34801561025957600080fd5b50610131610411565b34801561026e57600080fd5b506100a7610420565b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156103005780601f106102d557610100808354040283529160200191610300565b820191906000526020600020905b8154815290600101906020018083116102e357829003601f168201915b5050505050905090565b600054600160a060020a031690565b600154600160a060020a031633141561033a57600154600160a060020a0316ff5b565b600154600160a060020a031690565b600154600160a060020a031681565b600080546001805460028054604080516020601f6000199785161561010002979097019093168490049586018390048302810183019091528481528695606095600160a060020a039182169590911693928391908301828280156103ff5780601f106103d4576101008083540402835291602001916103ff565b820191906000526020600020905b8154815290600101906020018083116103e257829003601f168201915b50505050509050925092509250909192565b600054600160a060020a031681565b6002805460408051602060018416156101000260001901909316849004601f810184900484028201840190925281815292918301828280156104a35780601f10610478576101008083540402835291602001916104a3565b820191906000526020600020905b81548152906001019060200180831161048657829003601f168201915b5050505050815600a165627a7a72305820114db487c5afe11e3bfe13bd5b6ed96d6b9cc4dd058353ce1d2b052f46c459580029";

    public static final String FUNC_GETINFO = "getInfo";

    public static final String FUNC_GETCOW = "getCow";

    public static final String FUNC_CLOSECONTRACT = "closeContract";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_GETINFORMATION = "getInformation";

    public static final String FUNC_COW = "cow";

    public static final String FUNC_INFORMATION = "information";

    protected P3AbsoluteBasic_sol_CowOwnerInfo(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected P3AbsoluteBasic_sol_CowOwnerInfo(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> getInfo() {
        final Function function = new Function(FUNC_GETINFO, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getCow() {
        final Function function = new Function(FUNC_GETCOW, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> closeContract() {
        final Function function = new Function(
                FUNC_CLOSECONTRACT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple3<String, String, String>> getInformation() {
        final Function function = new Function(FUNC_GETINFORMATION, 
                Arrays.<Type>asList(), 
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

    public RemoteCall<String> cow() {
        final Function function = new Function(FUNC_COW, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> information() {
        final Function function = new Function(FUNC_INFORMATION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<P3AbsoluteBasic_sol_CowOwnerInfo> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String c, String info) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(c), 
                new org.web3j.abi.datatypes.Utf8String(info)));
        return deployRemoteCall(P3AbsoluteBasic_sol_CowOwnerInfo.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<P3AbsoluteBasic_sol_CowOwnerInfo> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String c, String info) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(c), 
                new org.web3j.abi.datatypes.Utf8String(info)));
        return deployRemoteCall(P3AbsoluteBasic_sol_CowOwnerInfo.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static P3AbsoluteBasic_sol_CowOwnerInfo load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new P3AbsoluteBasic_sol_CowOwnerInfo(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static P3AbsoluteBasic_sol_CowOwnerInfo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new P3AbsoluteBasic_sol_CowOwnerInfo(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
