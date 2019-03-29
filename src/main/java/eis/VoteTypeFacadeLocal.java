/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.VoteType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface VoteTypeFacadeLocal {

    void create(VoteType voteType);

    void edit(VoteType voteType);

    void remove(VoteType voteType);

    VoteType find(Object id);

    List<VoteType> findAll();

    List<VoteType> findRange(int[] range);

    int count();
    
}
