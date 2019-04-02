package framework.easytcc.remoting;

import framework.easytcc.transaction.TransactionStatus;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class NonOpTransactionChannel implements TransactionChannel {
	@Override
	public void preDownstreamAnnotedMethodExec(String upstreamApplication) {
	}

	@Override
	public boolean sendTransaction(String application, String xid, TransactionStatus transactionStatus) {
		return false;
	}
}