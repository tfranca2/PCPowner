package com.exemplo.controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.exemplo.entidade.Volume;
import com.exemplo.repositorio.RepositorioVolume;

@ManagedBean
@SessionScoped
public class ControleVolume {
	private Volume volume;
	private List<Volume> volumes;
	private RepositorioVolume repositorioVolume;
	
	public ControleVolume(){
		repositorioVolume = new RepositorioVolume();
	}
	
	public String novo(){
		volume = new Volume();
		return "formularioVolume";
	}
	
	public String salvar(){
		repositorioVolume.salvar(volume);
		return "listarVolumes";
	}

	public String editar(Volume volume){
		this.volume = volume;
		return "formularioVolume";
	}
	
	public String remover(Volume volume){
		repositorioVolume.remover(volume);
		return null;
	}
	
	public String cancelar(){
		return "listarVolumes";
	}
	
	public Volume obterPorId(int id){
		return repositorioVolume.ObterPorId(id);
	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	public List<Volume> getVolumes() {
		volumes = repositorioVolume.listarTodos();
		return volumes;
	}

	public void setVolumes(List<Volume> volumes) {
		this.volumes = volumes;
	}
	
}
