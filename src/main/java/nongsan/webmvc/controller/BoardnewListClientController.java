package nongsan.webmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nongsan.webmvc.model.BoardNew;
import nongsan.webmvc.service.IBoardNewService;

public class BoardnewListClientController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Inject
    IBoardNewService boardNewService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BoardNew> boardnewList = boardNewService.findAllBoardNew();
        req.setAttribute("boardnewlist", boardnewList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/client/blog-archive.jsp");
        dispatcher.forward(req, resp);
    }
}
