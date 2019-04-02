package framework.easytcc.repository;

import java.util.List;

import framework.easytcc.context.Xid;
import framework.easytcc.transaction.TransactionStatus;

/**
 * @author Fangfang.Xu
 *
 */
public interface XidRepository {

	/**
	 * create new xid data
	 * @param xid
	 */
	void createXid(Xid xid);
	
	/**
	 * Useless means create before {@link createSecondsBefore} and didn't had any transactions in it's field
	 * @param createSecondsBefore
	 * @return
	 */
	List<Xid> findAllUseless(int createSecondsBefore);
	
	TransactionStatus findXidTransactionStatus(String xid);
	
	void deleteXid(String xid);
	/**
	 * update status to commit
	 * @param xid
	 */
	void updateToCommit(String xid);
	
	void updateToRollback(String xid);
	
}
