/**
 * 
 */
package test.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * @author AB0055518
 *
 */
@Embeddable
public class Item {
	@Column(name="ITEM_CODE")
	private String code;
	@Column(name="ITEM_NAME")
	private String name;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Item [code=" + code + ", name=" + name + "]";
	}
	
}
