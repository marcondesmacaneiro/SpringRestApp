package br.edu.unidavi.restapp;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vinicius
 */
@RestController
@RequestMapping("/produtoteste")
@EnableHypermediaSupport(type = {HypermediaType.HAL})
public class ProdutoController {
    
    @Autowired
    ProdutoRepository produtoRepository;
    
    @RequestMapping(method=RequestMethod.GET)
    public HttpEntity<List<Produto>> getProdutos(){
        ArrayList<Produto> produtos = Lists.newArrayList(produtoRepository.findAll());
        for(Produto produto : produtos){
            produto.add(linkTo(ControllerLinkBuilder.methodOn(ProdutoController.class).getProdutos()).withSelfRel());
        }
        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Produto> setProduto( @RequestBody Produto produtoNovo){      
        produtoRepository.save(produtoNovo);
        return new ResponseEntity<Produto>(produtoNovo, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{nome}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Produto> setProduto(@PathVariable String nome, @RequestBody Produto produtoNovo){
        ArrayList<Produto> produtos = Lists.newArrayList(produtoRepository.findByNome(nome));
        Produto produto = produtos.get(0);
        produto.setNome(produtoNovo.getNome());
        produtoRepository.save(produto);
        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }
    
    @RequestMapping(value="/{nome}", method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public HttpEntity<Produto> deleteProduto(@PathVariable String nome, @RequestBody Produto produtoNovo){
        ArrayList<Produto> produtos = Lists.newArrayList(produtoRepository.findByNome(nome));
        Produto produto = produtos.get(0);
        produtoRepository.delete(produto);
        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }
    
    
}
