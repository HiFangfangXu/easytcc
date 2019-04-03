package github.easytcc.remoting;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import github.easytcc.repository.factory.RepositoryFactory;
import github.easytcc.transaction.LocalTransaction;
import github.easytcc.transaction.TransactionStatus;

/**
 * 
 * @author Fangfang.Xu
 *
 */
public class ServerTransactionExecutor {
	
	static Logger logger = LoggerFactory.getLogger(ServerTransactionExecutor.class);

	public void execute(String xid,TransactionStatus transactionStatus) {
		List<LocalTransaction> localTransactions = RepositoryFactory.getLocalTransactionRepository().findLocalTransactions(xid);
		
		if(logger.isDebugEnabled()) {
			logger.debug("finded localTransactions size:{}",localTransactions.size());			
		}
		for(LocalTransaction localTransaction:localTransactions){
			if (TransactionStatus.COMMIT.equals(transactionStatus)) {
				localTransaction.commit();
			}
			if (TransactionStatus.ROLLBACK.equals(transactionStatus)) {
				localTransaction.rollback();
			}
		}
	}
}