/**
 * 
 */
package com.mindtree.vehiclebusiness.controller;

import java.beans.PropertyEditorSupport;

import com.mindtree.vehiclebusiness.entity.Vehicle;

/**
 * @author M1018339
 *
 */
public class VehicleEditor extends PropertyEditorSupport {
	
	private Vehicle veh = new Vehicle();
	
	@Override
	public void setAsText(String str) throws IllegalArgumentException{
		System.out.println("Coming Veh Editor" + str);
		if(str != null){
			veh.setRegNo(str);
		}
	}
	
	@Override
	public Object getValue(){
		return veh;
	}
}
