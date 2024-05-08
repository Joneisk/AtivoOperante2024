/*
 * Fonte: https://www.devmedia.com.br/validar-cpf-com-javascript/23916 (Em Português)
 *        https://forum.imasters.com.br/topic/140772-resolvido-validar-cpf/ (Em Português)
 *
 * Função adaptada por Francisco Chaves <contato@franciscochaves.com.br>
 *
 * CPF correto retorna true, senão false.
 */

function verifyCPF(cpf) {
    let sum = 0;
    let rest = 0;
  
    let { cpfValid, isValid } = validFormatCPF(cpf);
  
    if (!isValid) return false;
  
    for (i = 1; i <= 9; i++) {
      sum = sum + parseInt(cpfValid.substring(i - 1, i)) * (11 - i);
    }
  
    rest = (sum * 10) % 11;
  
    if (rest == 10 || rest == 11) rest = 0;
  
    if (rest != parseInt(cpfValid.substring(9, 10))) return false;
  
    sum = 0;
  
    for (i = 1; i <= 10; i++) {
      sum = sum + parseInt(cpfValid.substring(i - 1, i)) * (12 - i);
    }
  
    rest = (sum * 10) % 11;
  
    if (rest == 10 || rest == 11) rest = 0;
  
    if (rest != parseInt(cpfValid.substring(10, 11))) return false;
  
    return true;
  }
  
  const validFormatCPF = (cpf) => {
    const regexValidCPF = /^\d{3}\.?\d{3}\.?\d{3}\-?\d{2}$/;
  
    if (!cpf.match(regexValidCPF)) {
      return {
        cpfValid: cpf,
        isValid: false,
      };
    }
  
    // Remove pontos e traços do CPF
    cpf = cpf.replace('-', '').replace(/\./g, '');
  
    // Verifica se o CPF possui números repetidos (ex: 111.111.111-11)
    if (cpf.match(/^(\d)\1{10}/g)) {
      return {
        cpfValid: cpf,
        isValid: false,
      };
    }
  
    return { cpfValid: cpf, isValid: true };
  };
  
  function validateCPF() {
    var cpfInput = document.getElementById('cpfInput');
    var cpf = cpfInput.value;

    var isValid = verifyCPF(cpf);

    var cpfValidationMessage = document.getElementById('cpfValidationMessage');

    if (isValid) {
        cpfValidationMessage.innerText = 'CPF válido';
        cpfValidationMessage.style.color = 'green';
    } else {
        cpfValidationMessage.innerText = 'CPF inválido';
        cpfValidationMessage.style.color = 'red';
    }
}