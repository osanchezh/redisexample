package com.buffer.datarediscache.entity;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2982572051754465148L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
	public Usuario(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	public Usuario() {
		super();
	}
	
}
