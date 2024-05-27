package com.project.cashRich.services;


import com.project.cashRich.model.Api3dParty;
import com.project.cashRich.model.User;

/**
 * @author Nehal Ansari
 */

public interface Api3dService {
//    void makeApiRequest(Long userId);
     Api3dParty consumeApi(String symbol);

}

