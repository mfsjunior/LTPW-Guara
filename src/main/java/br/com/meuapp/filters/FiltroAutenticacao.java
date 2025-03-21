package br.com.meuapp.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class FiltroAutenticacao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialização opcional
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        boolean usuarioLogado = (session != null && session.getAttribute("usuarioLogado") != null);
        String paginaAcessada = req.getRequestURI();

        // Se o usuário não está logado e tenta acessar index.xhtml, redireciona para login.xhtml
        if (!usuarioLogado && paginaAcessada.contains("index.xhtml")) {
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Finalização opcional
    }
}
