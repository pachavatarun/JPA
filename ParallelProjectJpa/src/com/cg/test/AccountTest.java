package com.cg.test;

import static org.junit.Assert.* ;

import org.junit.Before;
import org.junit.Test;

import com.cg.bean.Account;
import com.cg.exception.AccountException;
import com.cg.service.AccountService;
import com.cg.service.AccountServiceImpl;

public class AccountTest {

private AccountService service= new AccountServiceImpl();
	


@Before
public void init() {
service = new AccountServiceImpl();
}

@Test
public void testCreateNewAccountForMobile() {
Account acc = new Account();
acc.setPhoneNo("99897");
acc.setName("Ramesh");
acc.setEmailId("ramesh@gmail.com");
acc.setBalance(1000.0);
try {
service.createNewAccount(acc);
} catch (AccountException e) {
assertEquals("Phone number should be 10 digits", e.getMessage());
}
}
 
@Test
public void testCreateNewAccountForName() {
Account acc = new Account();
acc.setPhoneNo("9876543210");
acc.setName("ramesh");
acc.setEmailId("ramesh@gmail.com");
acc.setBalance(100.0);
try {
service.createNewAccount(acc);
} catch (AccountException e) {
assertEquals("Name should start with capital letter with minimum 3 characters and should contain only alphabets", e.getMessage());
}
}
 
@Test
public void testCreateNewAccountForName1() {
Account acc = new Account();
acc.setPhoneNo("9876543210");
acc.setName("John12");
acc.setEmailId("john@gmail.com");
acc.setBalance(2000.0);
try {
service.createNewAccount(acc);
} catch (AccountException e) {
assertEquals("Name should start with capital letter with minimum 3 characters and should contain only alphabets", e.getMessage());
}
}

@Test
public void testCreateNewAccountForNameIsEmpty() {
Account acc = new Account();
acc.setPhoneNo("9441674879");
acc.setName("");
acc.setEmailId("mahesh@gmail.com");
acc.setBalance(200.0);
try {
service.createNewAccount(acc);
} catch (AccountException e) {
assertEquals("Name cannot be empty", e.getMessage());
}
}



 
@Test
public void testCreateNewAccount() {
Account acc = new Account();
acc.setPhoneNo("9849228578");
acc.setName("Raju kumar");
acc.setEmailId("Raju@gmail.com");
acc.setBalance(2050.0);
 
try {
String s=service.createNewAccount(acc);
assertNotNull(s);
} catch (AccountException e) {

 
}
 
}
 
@Test
public void testShowBalanceForMobileNo() {

try {
service.showBalance("987654");
} catch (AccountException e) {

assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}
 



@Test
public void testDepositForMobileNo() {
Account acc=new Account();
acc.setPhoneNo("998979695");
try {
service.deposit(acc.getPhoneNo(), 230);
} catch (AccountException e) {
assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}

@Test
public void testDepositForDepositAmt1() {
Account acc=new Account();
acc.setPhoneNo("9441674879");
try {
service.deposit(acc.getPhoneNo(),-230);
} catch (AccountException e) {
assertEquals("Deposit amount must be greater than zero",e.getMessage());
}
}

 
@Test
public void testWithDrawForMobileNo() {
Account acc=new Account();
acc.setPhoneNo("99897969");
try {
service.withdraw(acc.getPhoneNo(), 230);
} catch (AccountException e) {
// TODO Auto-generated catch block
assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}

@Test
public void testWithdrawForAmt() {
Account acc=new Account();
acc.setPhoneNo("9876543210");
try {
service.withdraw(acc.getPhoneNo(), -230);
} catch (AccountException e) {
// TODO Auto-generated catch block
assertEquals("The amount to be withdrawn should be less than available balance and Entered amount should be greater than zero",e.getMessage());
}
}
 




@Test
public void testFundTransferForMobileNo() {
Account acc=new Account();
Account acc1=new Account();
acc.setPhoneNo("9989796959");
acc1.setPhoneNo("984922");
try {
service.fundTransfer(acc.getPhoneNo(),acc1.getPhoneNo(), 230);
} catch (AccountException e) {
// TODO Auto-generated catch block
assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
}

@Test
public void testFundTransferForNegativeAmt() {
Account acc=new Account();
Account acc1=new Account();
acc.setPhoneNo("9989796959");
acc1.setPhoneNo("9849228579");
try {
service.fundTransfer(acc.getPhoneNo(), acc1.getPhoneNo(),  -230);
} catch (AccountException e) {
// TODO Auto-generated catch block
assertEquals("The amount to be withdrawn should be greater than available balance and Entered amount should be greater than zero",e.getMessage());
}
}



@Test
public void testPrinttransactionDetailsForMobileNo() {
Account acc=new Account();
acc.setPhoneNo("98765");
try {
Account acc1=service.printTransactionDetails(acc.getPhoneNo());
assertNotNull(acc1);
} catch (AccountException e) {
	assertEquals("Mobile number should contain 10 digits",e.getMessage());
}
 
}





}
