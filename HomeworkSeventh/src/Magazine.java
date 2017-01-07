/**
 * Created by Маргарита on 07.12.2016.
 */
 enum TypeOfMagazine {
    shiny, standart, funny
}

class Magazine extends Publication {

    TypeOfMagazine type;

    public Magazine () {

    }

    public  Magazine (String name, String publisher, int sizeInPages, TypeOfMagazine type) throws WrongInfoException {
        super(name, publisher, sizeInPages);

        switch (type) {
            case shiny:
            case standart:
                this.type = type;
                break;
            default:
                throw new WrongInfoException("You've entered wrong type of the magazine...");
        }

        this.type = type;
    }

    public TypeOfMagazine getCType() {
        return this.type;
    }

    public void setType(TypeOfMagazine type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "type='" + type + '\'' +
                "} " + super.toString();
    }
}
