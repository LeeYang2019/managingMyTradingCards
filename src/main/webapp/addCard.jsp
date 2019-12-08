<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import url="head.jsp"/>
<html>
    <c:import url="head.jsp"/>
    <body>
        <div class="container">
            <div class="row">
                <c:import url="header.jsp"/>
            </div>
            <div class="row">
                <c:import url="navbar.jsp"/>
            </div>
            <div class="row">
                <div class="col-12 mx-auto mb-3">
                    <div class="card border-muted">
                        <div class="card-header bg-muted">
                            <h4 class="text-dark">Add Card to Database</h4>
                        </div>
                        <div class="card-body">
                            <form id="cardForm" action="addCards" class="needs-validation" novalidate>

                                <div class="form-group row">
                                    <div class="col-md-6">
                                        <input type="cardName" class="form-control" id="cardName" placeholder="Name" name="cardName" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please fill out this field.</div>
                                    </div>
                                    <div class="col">
                                        <div class="col">
                                            <select class="form-control" id="cardType" name="cardType">
                                                <option value="">Type</option>
                                                <option value="Monster">Monster</option>
                                                <option value="Spell">Spell</option>
                                                <option value="Trap">Trap</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col">
                                        <select class="form-control" id="cardRarity" name="cardRarity">
                                            <option value="">Rarity</option>
                                            <option value="Common">Common</option>
                                            <option value="Rare">Rare</option>
                                            <option value="Super">Super</option>
                                            <option value="Ultra">Ultra</option>
                                            <option value="Secret">Secret</option>
                                            <option value="Prismatic">Prismatic</option>
                                        </select>
                                    </div>

                                </div>

                                <div class="form-group row">

                                    <div class="col">
                                        <input type="cardSet" class="form-control" id="cardSet" placeholder="Set" name="cardSet" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please fill out this field.</div>
                                    </div>

                                    <div class="col">
                                        <input type="cardIndex" class="form-control" id="cardIndex" placeholder="Card No." name="cardIndex" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please fill out this field.</div>
                                    </div>

                                    <div class="col">
                                        <input type="cardPrice" class="form-control" id="cardPrice" placeholder="Price" name="cardPrice" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please fill out this field.</div>
                                    </div>

                                    <div class="col">
                                        <input type="cardQuantity" class="form-control" id="cardQuantity" placeholder="Qty." name="cardQuantity" required>
                                        <div class="valid-feedback">Valid.</div>
                                        <div class="invalid-feedback">Please fill out this field.</div>
                                    </div>
                                </div>

                                <div class="row myButtons">
                                    <button type="submit" class="btn btn-primary">Add</button>
                                    <button type="reset" class="btn btn-danger">Cancel</button>
                                </div>

                            </form>
                        </div>
                        </div>
                    </div>
                </div>
            <footer class="row">
                <c:import url="footer.jsp"/>
            </footer>
        </div>
    </body>
</html>
