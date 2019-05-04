/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import domain.VoteType;
import eis.AbstractFacade;
import eis.VoteTypeFacade;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Path;

/**
 *
 * @author abraham
 */
@Stateless
@Path("domain.votetype")
public class VoteTypeFacadeREST extends AbstractREST<VoteType> {

    @Inject
    VoteTypeFacade facade;

    @Override
    public AbstractFacade facade() {
        return facade;
    }

}
