package trabalho1;

public class ListaDuplamenteEncadeada {
	private Nodo inicio; //atributo, referência para o primeiro nodo da lista
	

	public ListaDuplamenteEncadeada() //Método construtor 
	{
		this.setInicio(null); //inicializando a lista como vazia 
	}
	
	//getters e setters do atributo inicio
	public Nodo getInicio() {
		return inicio;
	}

	public void setInicio(Nodo inicio) {
		this.inicio = inicio;
	}

	public void inserirOrdem(int valor) {
	Nodo novo = new Nodo(valor, null, null); //cria um novo nodo, com o valor a ser inserido e os ponteiros ainda nulos 

	if(this.inicio == null) 
	//testar se a lista é vazia
		{
			this.inicio=novo; //define inicio como novo nodo e sai do método
			return; 	
		}
	
	//Verificar se valor já existe
	Nodo atual = inicio;  //cria uma variável auxiliar variável iniciando no primeiro nodo 
	while(atual != null)  //percorre cada nodo da lista ate que o atual seja nulo 
	{
		//laço que irá percorrer a lista para verificar se o valor ja existe, evitando inserir duplicatas a lista 
		if(atual.getValor() == valor) 
		{
			System.out.println("Valor: " +valor+ " já existe na lista, não será inserido");
			return; 
		}
		atual = atual.getProx(); //segue percorrendo para o próximo com o atual 
	}
	
	atual = this.inicio; //vai reiniciar a variável atual para o inicio, e usara para a posição que irá inserir o valor
	
	if(valor<atual.getValor()) 
	//inserção no inicio da lista 	
	//se o valor a ser inserido	for menor que o primeiro elemento, o novo nodo é inserido antes do primeiro nodo, passando a ser o inicio
	{
		novo.setProx(inicio); //faz o novo nodo apontar para o atual primeiro nodo 
		inicio.setAnt(novo); //faz o atual primeiro nodo apontar de voltar para o nodo novo 
		inicio = novo;   //atualiza o inicio apontando para esse novo nodo que vai entrar 
		return;
	}
	
	
	while(atual.getProx() != null /*ainda não chegou ao fim*/ && atual.getProx().getValor() <valor)
	//inserção no meio ou fim da lista 
	//percorre a lista até encontrar a posição certa para inserir 
	{
		atual = atual.getProx();
	}
	
	novo.setProx(atual.getProx());  //aponta para o próximo do atual 
	novo.setAnt(atual);//aponta para o atual
	
	if(atual.getProx() != null)
	//Se o atual não é o ultimo da lista, ajusta o ponteiro ant do próximo nodo para apontar para o novo nodo	
	{
		atual.getProx().setAnt(novo); //atual aponta para o novo nodo 
	}
	
	atual.setProx(novo); //liga o ponteiro proximo do atual ao novo nodo da lista 
	}

	public void imprime() {
		 
		if(this.inicio==null)
		{
			System.out.println("Lista Vazia");
		}
		else //percorre a lista toda, exibindo cada valor e sua posição
		{ 
			Nodo aux = this.inicio; 
			int posicao = 1; 
			while(aux != null) 
			{
				System.out.println("Posição: " +posicao+ " de Valor: " +aux.getValor());
				aux = aux.getProx(); //avança para o próximo nodo
				
				posicao ++; //contador 
			}
		}
	} 
	
	public void removeValor(int valor) {
		
		//verificar se a lista está vazia antes de tentar remover 
		if(this.inicio == null) 
		{
			System.out.println("Não é possível remover. Lista vazia!");
			return; 
		}
		
		//variável aux para percorrer a lista 
		Nodo aux = this.inicio; 
		
		while(aux != null)
		{
			if(aux.getValor() == valor) //verifica se é o primeiro nodo, então ajustaremos o inicio
			{
				if(aux == inicio) 
				{
					inicio=aux.getProx(); //move o ponteiro inicio para o proximo nodo		
					if(inicio!=null)
					inicio.setAnt(null); //limpa o ponteiro anterior
		} else { //ajusta os ponteiros, pulando o nodo
			aux.getAnt().setProx(aux.getProx()); 
			if(aux.getProx()!=null) 
				aux.getProx().setAnt(aux.getAnt());  
		}
			System.out.println("O valor: " +valor+ " foi removido");
			return;
		}
		
		aux = aux.getProx(); //continua a busca caso nao tenha achado nada ainda
	}
	
	System.out.println("O valor: " +valor+ " não foi encontrado.");
}


	public void pesquisaValor(int valor)
	{
		if(inicio == null)
		{
			System.out.println("Não é possível pesquisar. Lista Vazia!");
			return; 
		}
		
		//inicialização das variáveis
		Nodo aux = inicio;
		int posicao = 1; 
		
		while(aux!=null)
		{
			if(aux.getValor() == valor)
			{
				System.out.println("O valor: " +valor+ " encontrado na posição: " +posicao+ ".");
				return; 
			}
			
			aux = aux.getProx(); 
			posicao++; 
		}
		
		System.out.println("O valor : " +valor+ " não foi encontrado na lista.");
		
	}
}