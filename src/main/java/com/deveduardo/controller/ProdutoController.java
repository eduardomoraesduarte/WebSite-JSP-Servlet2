package com.deveduardo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deveduardo.dao.ProdutoDAO;
import com.deveduarteo.model.Produto;

@WebServlet("/publica")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProdutoDAO prod = new ProdutoDAO();

	public ProdutoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		processarRequisicao(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processarRequisicao(request, response);
	}

	private void processarRequisicao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-UTF-8");

		String acao = request.getParameter("acao");
		try {
			switch (acao) {
			case "inserir":
				gravarProduto(request, response);
				break;
			case "buscar":
				buscarProduto(request, response);
				break;
			}
		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

	private void gravarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		double quantidade = Double.parseDouble(request.getParameter("quantidade"));
		double preco = Double.parseDouble(request.getParameter("preco"));
		boolean online = false;
		String mensagem;

		Produto produto = new Produto(descricao, quantidade, preco, online);
		System.out.println(produto);
		prod.cadastrarProduto(produto);

		if (request.getParameter("online") != null && (request.getParameter("online").equals("on")))
			online = true;

		mensagem = "Produto Cadastrado com Sucesso!";
		request.setAttribute("mensagem", mensagem);

		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastrarProduto.jsp");
		dispatcher.forward(request, response);
	}

	private void buscarProduto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProdutoDAO prod2 = new ProdutoDAO();
		String desc = request.getParameter("descricao");
		if (desc == null || desc.isEmpty()) {
			System.out.println("Descrição não foi fornecida");
			return; // ou lance uma exceção
		}
		List<Produto> list = prod2.BuscarProdDesc(desc);
		request.setAttribute("produtos", list); // Adicione a lista como atributo

		RequestDispatcher dispatcher = request.getRequestDispatcher("consultarProduto.jsp"); // Redirecione para uma
																								// nova página
		dispatcher.forward(request, response);
	}
}
