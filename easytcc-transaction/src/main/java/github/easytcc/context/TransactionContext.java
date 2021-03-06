package github.easytcc.context;

import github.easytcc.transaction.LocalTransaction;

/**
 * every TransactionContext associate with a Xid
 * @author Fangfang.Xu
 *
 */
public interface TransactionContext {
	
	Xid getXid();
	
	String getUpstreamServer();
	
	String getParentId();
	
	LocalTransaction getLocalTransaction();
	
	void setLocalTransaction(LocalTransaction localTransaction);
}
