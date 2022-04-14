package com.ecommerce.ecommerce.service.Exception;

public class BDexcecao extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public BDexcecao(String msg){
        super(msg);
    }
}
