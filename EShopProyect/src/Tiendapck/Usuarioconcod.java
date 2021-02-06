package Tiendapck;

public class Usuarioconcod {

	String nickname;
	String cod;
	
	public Usuarioconcod(String nickname, String cod) {
		super();
		this.nickname = nickname;
		this.cod = cod;
	}


	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	@Override
	public String toString() {
		return "Usuarioconcod [nickname=" + nickname + ", cod=" + cod + "]";
	}
	
}
