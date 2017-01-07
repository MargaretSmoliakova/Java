/**
 * Created by Маргарита on 07.12.2016.
 */
 enum Colourity {
    black_white, color, pink, black
}

 class NewsPaper extends Publication {

    Colourity colourity;

    public NewsPaper () {

    }

    public NewsPaper (String name, String publisher, int sizeInPages, Colourity colourity) throws WrongInfoException {
        super(name, publisher, sizeInPages);

        switch (colourity) {
            case black_white:
            case color:
                this.colourity = colourity;
                break;
            default:
                throw new WrongInfoException("You've entered wrong colourity of you publication...");
        }
    }

    public Colourity getColourity() {
        return this.colourity;
    }

    public void setColourity(Colourity colourity) {
        this.colourity = colourity;
    }

    @Override
    public String toString() {
        return "NewsPaper{" +
                "colourity='" + colourity + '\'' +
                "} " + super.toString();
    }
}
