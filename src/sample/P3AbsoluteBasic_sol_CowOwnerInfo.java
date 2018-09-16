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
    private static final String BINARY = "60806040526040516104e13803806104e183398101604052805160208083015160008054600160a060020a038516600160a060020a03199182161790915560018054909116331790559092018051919290916100619160029190840190610069565b505050610104565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100aa57805160ff19168380011785556100d7565b828001600101855582156100d7579182015b828111156100d75782518255916020019190600101906100bc565b506100e39291506100e7565b5090565b61010191905b808211156100e357600081556001016100ed565b90565b6103ce806101136000396000f30060806040526004361061006c5763ffffffff7c01000000000000000000000000000000000000000000000000000000006000350416635a9b0b8981146100715780635f8988b5146100fb578063610be6541461012c578063893d20e814610143578063c0da1e6814610158575b600080fd5b34801561007d57600080fd5b50610086610217565b6040805160208082528351818301528351919283929083019185019080838360005b838110156100c05781810151838201526020016100a8565b50505050905090810190601f1680156100ed5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561010757600080fd5b506101106102aa565b60408051600160a060020a039092168252519081900360200190f35b34801561013857600080fd5b506101416102b9565b005b34801561014f57600080fd5b506101106102dc565b34801561016457600080fd5b5061016d6102eb565b6040518084600160a060020a0316600160a060020a0316815260200183600160a060020a0316600160a060020a0316815260200180602001828103825283818151815260200191508051906020019080838360005b838110156101da5781810151838201526020016101c2565b50505050905090810190601f1680156102075780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b60028054604080516020601f60001961010060018716150201909416859004938401819004810282018101909252828152606093909290918301828280156102a05780601f10610275576101008083540402835291602001916102a0565b820191906000526020600020905b81548152906001019060200180831161028357829003601f168201915b5050505050905090565b600054600160a060020a031690565b600154600160a060020a03163314156102da57600154600160a060020a0316ff5b565b600154600160a060020a031690565b600080546001805460028054604080516020601f6000199785161561010002979097019093168490049586018390048302810183019091528481528695606095600160a060020a039182169590911693928391908301828280156103905780601f1061036557610100808354040283529160200191610390565b820191906000526020600020905b81548152906001019060200180831161037357829003601f168201915b505050505090509250925092509091925600a165627a7a7230582032f61ff9c8b4b1422fe9f00f85fc1046b5104bbdc8cc9cb098b8aee7f94e6a6a0029";

    public static final String FUNC_GETINFO = "getInfo";

    public static final String FUNC_GETCOW = "getCow";

    public static final String FUNC_CLOSECONTRACT = "closeContract";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_GETINFORMATION = "getInformation";

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

    public static RemoteCall<P3AbsoluteBasic_sol_CowOwnerInfo> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String c, String info) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(c),
                new Utf8String(info)));
        return deployRemoteCall(P3AbsoluteBasic_sol_CowOwnerInfo.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static RemoteCall<P3AbsoluteBasic_sol_CowOwnerInfo> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue, String c, String info) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(c),
                new Utf8String(info)));
        return deployRemoteCall(P3AbsoluteBasic_sol_CowOwnerInfo.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor, initialWeiValue);
    }

    public static P3AbsoluteBasic_sol_CowOwnerInfo load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new P3AbsoluteBasic_sol_CowOwnerInfo(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static P3AbsoluteBasic_sol_CowOwnerInfo load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new P3AbsoluteBasic_sol_CowOwnerInfo(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}
