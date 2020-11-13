package Usuario;

import java.util.Date;

public class Usuario {

	private String nickname;
	private String password;
	private String correoElectronico;
	private Date fechaNacimiento;
	private String calle;
	private String tarjeta_credito;
	private boolean tipo_cuenta;

	public Usuario(String nickname, String password, String correoElectronico, Date fechaNacimiento, String calle,
			String tarjeta_credito, boolean tipo_cuenta) {
		super();
		this.nickname = nickname;
		this.password = password;
		this.correoElectronico = correoElectronico;
		this.fechaNacimiento = fechaNacimiento;
		this.calle = calle;
		this.tarjeta_credito = tarjeta_credito;
		this.tipo_cuenta = tipo_cuenta;
	}

	public Usuario() {
		super();
		this.nickname = "default";
		this.password = "default";
		this.correoElectronico = "default@def.def";
		this.fechaNacimiento = new Date();
		this.calle = "default";
		this.tarjeta_credito = "";
		this.tipo_cuenta = false;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getTarjeta_credito() {
		return tarjeta_credito;
	}

	public void setTarjeta_credito(String tarjeta) {
		this.tarjeta_credito = tarjeta;
	}

	public boolean isTipo_cuenta() {
		return tipo_cuenta;
	}

	public void setTipo_cuenta(boolean tipo_cuenta) {
		this.tipo_cuenta = tipo_cuenta;
	}

}