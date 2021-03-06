package edu.yang.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * YugiohCard object
 * @author Lee Yang
 */
@Entity(name="YugiohCard")
@Table(name="yugioh_card")
public class YugiohCard {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name="card_name")
    private String cardName;

    @Column(name="card_type")
    private String cardType;

    @Column(name = "card_rarity")
    private String cardRarity;

    @Column(name = "card_edition")
    private String cardEdition;

    @Column(name = "card_set")
    private String cardSet;

    @Column(name = "card_set_full_name")
    private String cardSetFullName;

    @Column(name = "card_index")
    private String cardIndex;

    @Column(name = "price")
    private double price;

    @Column(name = "qty")
    private int quantity;

    @Column(name = "status")
    private String status;

    @Column(name = "image")
    private String image;

    @ManyToOne
    private User user;

    @OneToMany (mappedBy = "yugiohCard", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<YugiohCardHistory> entries = new HashSet<>();

    /**
     * no arg constructor
     */
    public YugiohCard() {

    }

    /**
     * constructor
     * @param cardName
     * @param cardType
     * @param cardRarity
     * @param cardEdition
     * @param cardSet
     * @param cardSetFullName
     * @param index
     * @param price
     * @param quantity
     * @param status
     * @param image
     * @param user
     */
    public YugiohCard(String cardName, String cardType, String cardRarity, String cardEdition, String cardSet,
                      String cardSetFullName, String index, double price, int quantity, String status, String image, User user) {
        this.cardName = cardName;
        this.cardType = cardType;
        this.cardRarity = cardRarity;
        this.cardEdition = cardEdition;
        this.cardSet = cardSet;
        this.cardSetFullName = cardSetFullName;
        this.cardIndex = index;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.image = image;
        this.user = user;
    }

    /**
     * sets cardName
     * @param cardName
     */
    public void setCardName(String cardName) { this.cardName = cardName; }

    /**
     * sets cardType
     * @param cardType
     */
    public void setCardType(String cardType) { this.cardType = cardType; }

    /**
     * sets cardRarity
     * @param cardRarity
     */
    public void setCardRarity(String cardRarity) {
        this.cardRarity = cardRarity;
    }

    /**
     * sets cardEdition
     * @param cardEdition
     */
    public void setCardEdition(String cardEdition) {this.cardEdition = cardEdition;}

    /**
     * sets cardSet
     * @param cardSet
     */
    public void setCardSet(String cardSet) {
        this.cardSet = cardSet;
    }

    /**
     * sets cardSetFullName
     * @param cardSetFullName
     */
    public void setCardSetFullName(String cardSetFullName) { this.cardSetFullName = cardSetFullName;}

    /**
     * sets cardIndex
     * @param cardIndex
     */
    public void setIndex(String cardIndex) {
        this.cardIndex = cardIndex;
    }

    /**
     * sets price
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * sets quantity
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * sets status
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * sets image
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * sets user
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * gets the card id
     * @return id
     */
    public int getId() {
        return this.id;
    }
    /**
     * gets cardName
     * @return cardName
     */
    public String getCardName() { return this.cardName; }

    /**
     * gets cardType
     * @return cardType
     */
    public String getCardType() { return this.cardType; }

    /**
     * gets cardRarity
     * @return cardRarity
     */
    public String getCardRarity() {
        return this.cardRarity;
    }

    /**
     * gets cardEdition
     * @return cardEdition
     */
    public String getCardEdition() {return this.cardEdition;}

    /**
     * gets cardSetFullName
     * @return cardSetFullName
     */
    public String getSetName() {return this.cardSetFullName;}

    /**
     * gets cardSet
     * @return cardSet
     */
    public String getCardSet() {
        return this.cardSet;
    }

    /**
     * gets cardIndex
     * @return cardIndex
     */
    public String getCardIndex() {
        return this.cardIndex;
    }

    /**
     * gets price
     * @return price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * gets quantity
     * @return quantity
     */
    public int getQuantity() {
        return this.quantity;
    }

    /**
     * gets status
     * @return status
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * gets image
     * @return image
     */
    public String getImage() {
        return this.image;
    }


    /**
     * gets user
     * @return user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * sets entries set
     * @param entries
     */
    public void setEntries(Set<YugiohCardHistory> entries) {
        this.entries = entries;
    }

    /**
     * gets entries
     * @return entries
     */
    public Set<YugiohCardHistory> getEntries() {
        return this.entries;
    }

    /**
     * sets an entry
     * @param entry
     */
    public void addEntry(YugiohCardHistory entry) {
        entries.add(entry);
        entry.setYugiohCard(this);
    }

    /**
     * removes an entry
     * @param entry
     */
    public void removeEntry(YugiohCardHistory entry) {
        entries.remove(entry);
        entry.setYugiohCard(null);
    }

    @Override
    public String toString() {
        return "user: " + this.user + "\n" +
                "cardName : " + this.cardName + "\n" +
                "cardType : " + this.cardType + "\n" +
                "cardRarity : " + this.cardRarity + "\n" +
                "cardEdition : " + this.cardEdition + "\n" +
                "cardFulleSetName : " + this.cardSetFullName + "\n" +
                "cardSet : " + this.cardSet + "\n" +
                "price : " + this.price + "\n" +
                "quantity : " + this.quantity + "\n" +
                "image : " + this.image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YugiohCard card = (YugiohCard) o;
        return id == card.id &&
                Double.compare(card.price, price) == 0 &&
                quantity == card.quantity &&
                cardName.equals(card.cardName) &&
                cardType.equals(card.cardType) &&
                cardRarity.equals(card.cardRarity) &&
                cardEdition.equals(card.cardEdition) &&
                cardSet.equals(card.cardSet) &&
                cardSetFullName.equals(card.cardSetFullName) &&
                cardIndex.equals(card.cardIndex) &&
                status.equals(card.status) &&
                image.equals(card.image) &&
                user.equals(card.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cardName, cardType, cardRarity, cardEdition, cardSet, cardSetFullName, cardIndex, price, quantity, status, image, user);
    }
}

