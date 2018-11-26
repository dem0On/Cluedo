package Model;

public class InitPlateau {
    private TypeCase plateau[][];

    public InitPlateau() {
        setPlateau();
    }

    public void setPlateau(){
        TypeCase plateauTmp[][] = {
                {TypeCase.Bureau, TypeCase.Bureau , TypeCase.Bureau , TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, null,  TypeCase.Couloir, null, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, null,  TypeCase.Couloir, null, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain},
                {TypeCase.Bureau, TypeCase.Bureau , TypeCase.Bureau , TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Couloir,  TypeCase.Couloir, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain},
                {TypeCase.Bureau, TypeCase.Bureau , TypeCase.Bureau , TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Couloir,  TypeCase.Couloir, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain},
                {TypeCase.Bureau, TypeCase.Bureau , TypeCase.Bureau , TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Bureau, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Couloir,  TypeCase.Couloir, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain},
                {null, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Porte, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Couloir, TypeCase.Couloir, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain},
                {TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Hall, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Porte, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain, TypeCase.SalleDeBain},
                {null, TypeCase.Library, TypeCase.Library, TypeCase.Library, TypeCase.Library, TypeCase.Library, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Hall, TypeCase.Hall, TypeCase.Porte, TypeCase.Porte, TypeCase.Hall, TypeCase.Hall, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, TypeCase.Couloir, null}

        };
    }
}
