/**
 * @author Lazaar El Mahdi
 * @version Fevrier 2023
 **/
import java.util.Random;
public class AlgorithmeTri{
	protected int taille;
	protected Elements[] tab;
	
	/**
	 * Constructeur : 
	 * @param n la taille du tableau
	 * */
	public AlgorithmeTri(int n){
		this.taille = n;
		this.tab = new Elements[this.taille];
		for(int i = 0; i < taille; i++){
			tab[i] = new Elements();
		}
	}

	//Constructeur : null
	public AlgorithmeTri(){
		tab = new Elements[1];
		tab[0] = new Elements();
	    tab[0].setCle(0);
	    tab[0].setContenu(0.0);
	}

	/*
	 * Generation de nombre aleatoire.
	 * Des entiers pour la cle.
	 * Des double pour le contenu.
	 */
	public void initAleatoire(){
		int valCle;
		double valContenu;
		for(int i = 0; i < this.taille; i++){
			Random generateur = new Random();
			valCle = generateur.nextInt(50);
			tab[i].setCle(valCle);
			valContenu = generateur.nextDouble()*100;
			tab[i].setContenu(valContenu);
		}

	}
	/**
	 * Accesseur
	 * @return tab.length la taille du tableau
	*/
	public int getTaille(){
		return tab.length;
	}	
	/**
	* Methode d'echange de deux elements du tableau
	* @param tab Le tableau
	* @param a un indice
	* @param b un indice
	**/
   public void echanger(Elements [] tab, int a, int b){
   		Elements tmp ;
		tmp = tab[a];
		tab[a] = tab[b];
		tab[b] = tmp;
   }
	/*
	 * Methode de tri a bulles
	 */
	public void triBulle(){
		boolean echange = true;
		int i = 0;
		while(i < taille && echange == true){
			echange = false;
			for(int j = 0; j < taille - i - 1; j++){
				if(tab[j].getCle() > tab[j+1].getCle()){
					echanger(tab, j, j+1);
					echange = true;				
				}
			}
			i++;
		}
	}
	/**
	 * @param tab le tableau 
	 * @param debut indice du debut du tableau.
	 * @param fin indice du fin du tableau.
	 * @return indicePivot l'indice du pivot choisi.
	 **/
	public int partition(Elements[] tab,int debut, int fin){
        int g = debut + 1;
        int d = fin;
        int pivot = tab[debut].getCle();
        int indicePivot = 0;
        while(g < d){
            while(g < d && tab[g].getCle() < pivot){
                g++;
            }
            while(d > g && tab[d].getCle() > pivot){
                d--;
            }
            echanger(tab, g, d);
            if(g < d){
                g++;
                d--;
            }
        }
            if(g == d && tab[g].getCle() <= pivot){
                indicePivot = g;
            } else {
                indicePivot = g - 1;
            }
         echanger(tab, debut, indicePivot);
         return indicePivot;
    }
	// La methode recursive appelant la fonction partition
	public void triRapide(Elements[] tab,int debut, int fin){
		if(debut < fin){
			int pivot = partition(tab, debut, fin);
			triRapide(tab, debut, pivot - 1);
			triRapide(tab, pivot + 1, fin);
		}
	}
	/*
	 * Methode qui effectue un tri du tableau en manipulant les indices
	 */
	public void triDenombrement(){
	    // La taille du tableau intermediaire egale au plus grand element de tbaleau initiale + 1
		int max = tab[0].getCle();
		for(int i = 1 ; i < taille; i++){
			if(tab[i].getCle() > max){
				max = tab[i].getCle();
			}
		}
		int tailleC = max + 1;
		int [] tabInter = new int[tailleC];
		//Initialisation du tableau intermediaire a 0
		for(int i = 0; i < tailleC; i++){
			tabInter[i] = 0;
		}
		//Incrementation de la case ou se trouve l'indice tab[debut].getCle()
		for(int i = 0; i < taille; i++){
		    tabInter[tab[i].getCle()]++;
		}
		// Determination du rang
		for(int i = 1; i < tailleC; i++){
		    tabInter[i] = tabInter[i] + tabInter[i - 1];
		}
		Elements [] tabRes = new Elements[taille];
		for(int i = 0; i < taille; i++){
		    tabRes[i] = new Elements();
		}
		// Placer chaque élément dans la position determiner par tabInter
		// Decrementation de la case associée à la clé
		for(int i = taille - 1; i >= 0; i--){
		    tabRes[--tabInter[tab[i].getCle()]] = tab[i];
		}
		for(int i = 0; i < taille; i++){
		    tab[i] = tabRes[i];
		}
	}
	@Override
	public String toString(){
		String resultat = new String("[");
		for(int i = 0; i < taille; i++){
			resultat = resultat + "(" + tab[i].getCle() + ", " + tab[i].getContenu() + ")";
			if(i < taille - 1){
				resultat = resultat + ",";
			}
		}
		resultat = resultat + "]";
		return resultat;
	}
	public static void main(String[] args) {
	    int taille = 10;
	    AlgorithmeTri tab1 = new AlgorithmeTri(taille);
	    tab1.initAleatoire();
	    
	    System.out.println("Tableau avant le tri :");
	    System.out.println(tab1);
	    System.out.println("\n");
	    
	    long start1 = System.currentTimeMillis();
	    tab1.triBulle();
	    long stop1 = System.currentTimeMillis();
	    System.out.println("Tableau apres le tri a bulle :");
	    System.out.println(tab1);
	    System.out.println("Le temps en ms pour le tri a bulle est : " + (stop1 - start1) + "ms");
	    System.out.println("\n");
	    
	    long start2 = System.currentTimeMillis();
	    tab1.triRapide(tab1.tab, 0, tab1.getTaille() - 1);
	    long stop2 = System.currentTimeMillis();
	    System.out.println("Tableau apres le tri rapide :");
	    System.out.println(tab1);
	    System.out.println("Le temps en ms pour le tri rapide est : " + (stop2 - start2) + "ms");
	    System.out.println("\n");
	    
		long start3 = System.currentTimeMillis();
	    tab1.triDenombrement();
	    long stop3 = System.currentTimeMillis();
		System.out.println("Tableau apres le tri par denombrement :");
	    System.out.println(tab1);
	    System.out.println("Le temps en ms pour le tri par denombrement est : " + (stop3 - start3) + "ms");
	}
}