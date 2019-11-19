package edu.yang.controller;

import edu.yang.entity.User;
import edu.yang.entity.YugiohCard;
import edu.yang.persistence.ProjectDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * A simple servlet to search and return cards in the user's database
 */
@WebServlet(
        urlPatterns = {"/displayCard"}
)

public class DisplayCard extends HttpServlet {

    //logger
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        logger.info("entered displayCard servlet");

        HttpSession session = req.getSession();
        String input = req.getParameter("param");

        int id = Integer.parseInt(input);

        logger.info("this card id is " + id);

        ProjectDao yugiohCardDao = new ProjectDao(YugiohCard.class);

        YugiohCard newYugiohCard = (YugiohCard)yugiohCardDao.getById(id);

        logger.info("this cardName is" + newYugiohCard.getCardName());

        req.setAttribute("card", newYugiohCard);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/card.jsp");
        dispatcher.forward(req, resp);
    }
}