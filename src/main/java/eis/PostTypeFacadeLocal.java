/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.PostType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface PostTypeFacadeLocal {

    void create(PostType postType);

    void edit(PostType postType);

    void remove(PostType postType);

    PostType find(Object id);

    List<PostType> findAll();

    List<PostType> findRange(int[] range);

    int count();
    
}
