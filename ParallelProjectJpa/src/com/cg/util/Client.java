package com.cg.util;

import com.cg.bean.Account;
import com.cg.exception.AccountException;
import com.cg.service.AccountService;
import com.cg.service.AccountServiceImpl;

public class Client {

	public static void main(String[] args) {
		Account ac=new Account();
        AccountService service=new AccountServiceImpl();
        ac.setName("Akash");
        ac.setPhoneNo("9874563210");
        ac.setBalance(20000);
        ac.setEmailId("Akash@gmail.com");
try {
	service.createNewAccount(ac);
} catch (AccountException e) {
	// TODO Auto-generated catch block
	System.err.println(e.getMessage());
}
       
 
       /* try {
			System.out.println(service.showBalance("9999999999"));
		} catch (AccountException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
        
        
        try {
   
			System.out.println(service.deposit("9999999999", 5000.0));

		} catch (AccountException e) {
			System.err.println(e.getMessage());
		}
       try {
			System.out.println(service.withdraw("9999999999", 5000.0));
		} catch (AccountException e) {
			System.err.println(e.getMessage());
		}
        try {
			System.out.println(service.printTransactionDetails("9999999999"));

		} catch (AccountException e) {
			System.err.println(e.getMessage());
		}
        try {
			System.out.println(service.fundTransfer("8888888888", "9999999999", 5000));
		} catch (AccountException e) {
			System.err.println(e.getMessage());
		}
	}*/

	}
}


