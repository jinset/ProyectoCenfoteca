package com.cenfotec.cenfoteca.contracts;

public class TipoUsuarioRequest {
private String tipo;

public TipoUsuarioRequest(String tipo){
	super();
	this.tipo = tipo;
}

public String getTipo(){
	return tipo;
}
public void setTipo(String tipo){
	this.tipo = tipo;
}

}
