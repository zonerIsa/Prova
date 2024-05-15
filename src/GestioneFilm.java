public class GestioneFilm {
    private Film film[];
    private int maxFilm=0;

    public GestioneFilm(){
        film=new Film[maxFilm];
    }
    public GestioneFilm(int max){
        this.maxFilm=max;
        film=new Film[maxFilm];
    }
    public GestioneFilm(GestioneFilm g){
        this.film=new Film[g.film.length];
        for (int i = 0; i < film.length; i++) {
            if (g.film[i]!=null){
                this.film[i]=new Film(g.film[i]);
            }
        }
    }
    public int filmVisibili(){
        int conta=0;
        for (int i = 0; i < film.length; i++) {
            if (film[i]!=null){
                conta++;
            }
        }
        return conta;
    }

    public int aggiungiFilm(Film nuovo){
        int risult=-1;
        if (filmVisibili()<film.length){
            int i=0;
            while (i<filmVisibili() && nuovo.getValutaz()<film[i].getValutaz()){
                i++;
            }
            risult=i;

            for (int j = filmVisibili()-1; j>i; j--) {
                film[j]=film[j-1];
            }
            film[i]=new Film(nuovo);
        }

        return risult;
    }

    public int rimuoviFilm(String titolo){
        int risult=-1;
        int i=0;
        while (i<filmVisibili()&&risult==-1){
            if (film[i].getTitolo().equals(titolo)){
                risult=i;
            }
            i++;
        }
        if (risult!=-1){
            for (int j = risult; j < filmVisibili()-1; j++) {
                film[j]=film[j+1];
            }
            film[filmVisibili()-1]=null;
        }
        return risult;
    }

    public String toString(){
        String s="";
        for (int i = 0; i < filmVisibili(); i++) {
            s+=film[i].toString();
        }
        return s;
    }

    public double mediaValu(){
        double media=0;
        int somma=0;
        for (int i = 0; i < filmVisibili(); i++) {
            somma+=film[i].getValutaz();
        }
        media=somma/filmVisibili();
        return media;
    }

    public GestioneFilm unRegista(String regista){
        GestioneFilm g2=new GestioneFilm();
        for (int i = 0; i < filmVisibili(); i++) {
            if (film[i].getReg().equals(regista)){
                g2.aggiungiFilm(film[i]);
            }
        }
        return g2;
    }

    public Film cercaPerTitolo(String titolo){
        int i=0;
        boolean trovato=false;
        while (i<filmVisibili()&&!trovato){
            if (film[i].getTitolo().equals(titolo))
                trovato=true;
            
            i++;
        }
        if (trovato=true){
            return new Film(film[i-1]);
        } else {
            return null;
        }
    }
}
