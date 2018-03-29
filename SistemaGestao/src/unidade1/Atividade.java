package unidade1;

import java.util.ArrayList;

public class Atividade
{
	private int identificacao;
	public String recurso;
	private String tipo;
	private String titulo;
	private String descricao;
	private String participantes;
	private String material;
	private String informacao;

	public Atividade(int id)
	{
		this.identificacao = id;
	}
	public void  all(String recurso, String tipo, String titulo, String descricao, String material,
			String participantes)
	{
		this.recurso = recurso;
		this.tipo = tipo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.material = material;
		this.participantes = participantes;
	}
 	public int getId()
	{
		return this.identificacao;
	}

	public void setRecurso(String recurso)
	{
		this.recurso = recurso;
	}
	public String getRecurso()
	{
		return this.recurso;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	public String getTipo()
	{
		return this.tipo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	public String getTitulo()
	{
		return this.titulo;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}
	public String getDescricao()
	{
		return  this.descricao;
	}

	public void setInfo(String info)
	{
		this.informacao = info;
	}
	public String getInfo()
	{
		return this.informacao;
	}

	public void setParticipantes(String participantes)
	{
		this.participantes = participantes;
	}
	public String getParticipantes()
	{
		return this.participantes;
	}

	public void setMaterial(String material)
	{
		this.material = material;
	}
	public void contaTipo(ArrayList<Atividade> atividades, String recurso)
	{
		int cont  =0;
		for(int i = 0; i < atividades.size(); i+=1)
		{
			if(atividades.get(i).getRecurso().equals(recurso))
				cont+=1;
		}
		System.out.printf("Quantidade de %s alocado(a): %d%n", recurso, cont);
	}
}
