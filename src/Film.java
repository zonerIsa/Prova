public class Film { 
    private String titolo;
    private String regista;
    private int anno=0;
    private int valutaz=0;

    public Film(){}
    public Film (String titolo, String regista, int anno, int valutaz){
        setAnno(anno);
        setRegista(regista);
        setTitolo(titolo);
        setValutaz(valutaz);
    }
    public Film (Film film2){
        setAnno(film2.getAnno());
        setRegista(film2.getReg());
        setTitolo(film2.getTitolo());
        setValutaz(film2.getValutaz());
    }

    public void setTitolo(String titolo){
        this.titolo=titolo;
    }
    public void setRegista(String regista){
        this.regista=regista;
    }
    public void setAnno(int anno){
        this.anno=anno;
    }
    public void setValutaz(int valutaz){
        this.valutaz=valutaz;
    }

    public String getTitolo(){
        return titolo;
    }
    public String getReg(){
        return regista;
    }
    public int getAnno(){
        return anno;
    }
    public int getValutaz(){
        return valutaz;
    }

    public String toString(){
        String s = "";
        if (valutaz<=10 && valutaz>=0){
            s=String.format("Titolo: %s, regista: %s, anno: %d, valu: %d", titolo,regista,anno,valutaz);
        } else {
            s=String.format("Titolo: %s, regista: %s, anno: %d, valu: non valida", titolo,regista,anno);
        }
        return s;
    }

    public boolean equals(Object o){
        boolean uguali=false;
        if (this==o){
            uguali=true;
        } else if (o instanceof Film){
            Film film2=(Film)o;
            if (this.getTitolo().equals(film2.getTitolo())&&this.getReg().equals(film2.getReg())){
                uguali=true;
            }
        }
        return uguali;
    }
}
