package com.productinfo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Failure implements ProdType{
	// to return as json data
	String errorMessage;
	

}
