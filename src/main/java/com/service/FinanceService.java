/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.entity.Redeem;
import com.entity.RedeemUser;
import com.entity.Transaction;
import java.util.List;

/**
 *
 * @author ryan
 */
public interface FinanceService {
    
    public List<Transaction> getAllTransaction();
    
    public Transaction GetTransactionById(int id);
    
    public List<Redeem> getAllRedeem();
    
    public Redeem geTredeemById(int id);
    
    public List<RedeemUser> getAllRedeemUser();
    
    public RedeemUser getRedeemUserById(int id);
    
    public List<RedeemUser> getRedeemUserByUserId(int id);
    
    public void changeRedeenStatus(int id);
    
    public void saveRedeem(Redeem redeem);
    
}
