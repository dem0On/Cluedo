package Model.Plateau;

public class InitPlateau {
    private TypeCase plateau[][];

    public InitPlateau() {
        plateau = new TypeCase[24][25];
        setPlateau();
    }

    public void setPlateau(){
        for (int x = 0; x < 24; x++) {
            for (int y = 0; y < 25; y++) {

                // Piece Bureau
                if( (x>=0 && x<=6) && (y>=0 && y<=3) ){
                    if(x==6 && y==3) plateau[x][y] = TypeCase.PorteVerticale; // Porte
                    else plateau[x][y] = TypeCase.Bureau;
                }

                // Piece Hall
                else if( (x>=9 && x<=14) && (y>=0 && y<=6) ){
                    if(x==11 && y==6 || x==12 && y==6 ) plateau[x][y] = TypeCase.PorteVerticale; // Porte
                    else if(x==9 && y==4) plateau[x][y] = TypeCase.PorteHorizontal; // Porte
                    else plateau[x][y] = TypeCase.Hall;
                }

                // Piece Salle de Bain
                else if( (x>=17 && x<24) && (y>=0 && y<=5) ){
                    if(x==17 && y==5 ) plateau[x][y] = TypeCase.PorteVerticale; // Porte
                    else plateau[x][y] = TypeCase.SalleDeBain;
                }

                // Piece Bibliothéque
                else if( (x>=0 && x<=6) && (y>=6 && y<=10) ){
                    if(x==6 && y==8 ) plateau[x][y] = TypeCase.PorteHorizontal; // Porte
                    else if(x==3 && y==10) plateau[x][y] = TypeCase.PorteVerticale; // Porte
                    else if(x==6 && (y==6 || y==10)) plateau[x][y] = TypeCase.Couloir; // Couloir
                    else plateau[x][y] = TypeCase.Library;
                }

                // Piece Millieu
                else if( (x>=9 && x<=13) && (y>=8 && y<=14) ){
                    plateau[x][y] = TypeCase.Centre;
                }

                // Piece Salle a Manger
                else if( (x>=16 && x<24) && (y>=9 && y<=15) ){
                    if(x==16 && y==12 ) plateau[x][y] = TypeCase.PorteHorizontal; // Porte
                    else if(x==17 && y==9) plateau[x][y] = TypeCase.PorteVerticale; // Porte
                    else if(y==15 && x>=16 && x<=18) plateau[x][y] = TypeCase.Couloir; // Couloir
                    else plateau[x][y] = TypeCase.SalleManger;
                }

                // Piece Cuisine
                else if( (x>=18 && x<24) && (y>=18 && y<=24) ){
                    if(x==19 && y==18 ) plateau[x][y] = TypeCase.PorteVerticale; // Porte
                    else plateau[x][y] = TypeCase.Cuisine;
                }

                // Piece Salle Danse
                else if( (x>=8 && x<=15) && (y>=17 && y<=22) ){
                    if(x==9 && y==17 || x==14 && y==17 ) plateau[x][y] = TypeCase.PorteVerticale; // Porte
                    else if((x==8 || x==15) && y==19) plateau[x][y] = TypeCase.PorteHorizontal; // Porte
                    else plateau[x][y] = TypeCase.SalleDanse;
                }
                else if( (x>=10 && x<=14) && (y>=23 && y<=24) ){
                    plateau[x][y] = TypeCase.SalleDanse;
                }

                // Piece Conservatoire
                else if( (x>=0 && x<=5) && (y>=19 && y<=24) ){
                    if(x==4 && y==19) plateau[x][y] = TypeCase.PorteHorizontal; // Porte
                    else if(x==5 && y==19) plateau[x][y] = TypeCase.Couloir; // Couloir
                    else plateau[x][y] = TypeCase.Conservatoire;
                }

                // Piece Billard
                else if( (x>=0 && x<=5) && (y>=12 && y<=16) ){
                    if(x==1 && y==12 ) plateau[x][y] = TypeCase.PorteVerticale; // Porte
                    else if(x==5 && y==15) plateau[x][y] = TypeCase.PorteHorizontal; // Porte
                    else plateau[x][y] = TypeCase.SalleBiallard;
                }

                //Zone Vide-Bas
                else if(( (x>=0 && x<=8) || (x>=16 && x<=24) ) && y==24){
                    plateau[x][y] = null;
                }
                else if( (x==6 || x==17) && y==23){
                    plateau[x][y] = null;
                }

                //Zone Vide-Gauche
                else if( x==0 && (y==4 || y==11 || y==17 ) ){
                    plateau[x][y] = null;
                }

                //Zone Vide-Droite
                else if( x==23 && (y==6 || y==8 || y==16 ) ){
                    plateau[x][y] = null;
                }

                //Zone Vide-Haut
                else if( (x==8 || x==15)  && y==0){
                    plateau[x][y] = null;
                }

                //Placement Départ joueur
                else if( x==16 && y==0 ){
                    plateau[x][y] = TypeCase.DepartRouge;
                }

                else if( x==23 && y==7 ){
                    plateau[x][y] = TypeCase.DepartJaune;
                }

                else if( x==14 && y==24 ){
                    plateau[x][y] = TypeCase.DepartBlanc;
                }

                else if( x==9 && y==24 ){
                    plateau[x][y] = TypeCase.DepartVert;
                }

                else if( x==0 && y==18 ){
                    plateau[x][y] = TypeCase.DepartBleu;
                }

                else if( x==0 && y==5 ){
                    plateau[x][y] = TypeCase.DepartViolet;
                }

                else{
                    plateau[x][y] = TypeCase.Couloir;
                }
            }
        }
    }

    public TypeCase[][] getPlateau() {
        return plateau;
    }
}

