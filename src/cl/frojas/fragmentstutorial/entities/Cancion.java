package cl.frojas.fragmentstutorial.entities;

public class Cancion {
	
	private String artista;
	private String cancion;
	private String reproductor;
	
	public Cancion(String artista, String cancion, String reproductor) {
		super();
		this.artista = artista;
		this.cancion = cancion;
		this.reproductor = reproductor;
	}
	
	public Cancion() {
	}

	public String getArtista() {
		return artista;
	}
	public void setArtista(String artista) {
		this.artista = artista;
	}
	public String getCancion() {
		return cancion;
	}
	public void setCancion(String cancion) {
		this.cancion = cancion;
	}

	public String getReproductor() {
		return reproductor;
	}

	public void setReproductor(String reproductor) {
		this.reproductor = reproductor;
	}
}
