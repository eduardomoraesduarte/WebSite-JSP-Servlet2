
 /**
 * Validador de campos a serem inseridos
 */
function validar() {
    // Obtendo os valores dos campos
    let descritivo = frmProduto.descricao.value.trim();
    let quantidade = frmProduto.quantidade.value.trim();
    let preco = frmProduto.preco.value.trim();

    // Validação do campo Descritivo
    if (descritivo === "") {
        alert('Preencha o campo Descritivo');
        frmProduto.descricao.focus();
        return false;
    }

    // Validação do campo Quantidade
    if (quantidade === "") {
        alert('Preencha o campo Quantidade');
        frmProduto.quantidade.focus();
        return false;
    } else if (isNaN(quantidade)) {
        alert('O campo Quantidade deve ser um número válido');
        frmProduto.quantidade.focus();
        return false;
    }

    // Validação do campo Preço
    if (preco === "") {
        alert('Preencha o campo Preço');
        frmProduto.preco.focus();
        return false;
    } else if (isNaN(preco)) {
        alert('O campo Preço deve ser um número válido');
        frmProduto.preco.focus();
        return false;
    }

    // Se tudo estiver válido, o formulário será enviado
    document.forms["frmProduto"].submit();
}