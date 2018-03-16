import model.RedeRelacionamento;
import model.Usuario;

public class iFace {
	
	public static void main(String[] args) {
		Interface interfaceMenu = new Interface();
		Usuario usuarioAtivo = null;
		RedeRelacionamento redeRelacionamento = new RedeRelacionamento();
		String opcao;
		
		do {
			opcao = interfaceMenu.principal(usuarioAtivo);
			
			switch(opcao){
				case "1":
					if(usuarioAtivo == null){
						usuarioAtivo = interfaceMenu.entrar(redeRelacionamento);
						if(usuarioAtivo == null)
							System.out.println("Email ou senha incorreta!");
					}else{
						usuarioAtivo.setPerfilUsuario(interfaceMenu.criarPerfil(usuarioAtivo,redeRelacionamento));
					}
					
					break;
				case "2":
					if(usuarioAtivo == null){
						Usuario novoUsuario = interfaceMenu.cadastrarUsuario();
						redeRelacionamento.adicionarUsuario(novoUsuario);
						usuarioAtivo = novoUsuario;
					}else{
						interfaceMenu.adicionarAmigo(usuarioAtivo,redeRelacionamento);
					}
					
					break;
				case "3":
					if(usuarioAtivo == null){
						interfaceMenu.reativarConta(redeRelacionamento);
					}else{
						interfaceMenu.visualizarPedidosAmizade(usuarioAtivo,redeRelacionamento);
					}
					
					break;
				case "4":
					interfaceMenu.enviarMensagem(usuarioAtivo, redeRelacionamento);
					break;
				case "5":
					interfaceMenu.visualizarMensagens(usuarioAtivo, redeRelacionamento);
					break;
				case "6":
					interfaceMenu.cadastrarComunidade(usuarioAtivo, redeRelacionamento);
					break;
				case "7":
					interfaceMenu.entrarComunidade(usuarioAtivo, redeRelacionamento);
					break;
				case "8":
					boolean flag = interfaceMenu.apagarConta(usuarioAtivo, redeRelacionamento);
					if(flag)
						usuarioAtivo = null;
					break;
				case "9":
					usuarioAtivo = null;
					break;
			}
			
		}while(opcao.equals("0") == false);
		System.out.println("Sistema encerrado.");
	}
	
}
