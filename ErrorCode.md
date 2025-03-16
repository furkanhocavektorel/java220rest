# h1 tag i yerine geçer
## h2
### h3
- asd
* 2.eleman
  * 2.1 katman
    * 2.1.1

> merhaba bu metindir.  
> java220 ye hg  
> markdown dersi
> iki space ile asagi geçersiniz


* exception handler kod örneği aşağıda verilmişir.

```
    @ExceptionHandler(CategoryException.class)
    public ExceptionMessage CategoryExceptionHandler(CategoryException e){

        ExceptionMessage exceptionMessage= new ExceptionMessage();
        exceptionMessage.setCode(6001);
        exceptionMessage.setMessage(e.getMessage());

        return exceptionMessage;
    }
 ```

* exception handler kullanım örneği de:  

` Category category = categoryService.findById(dto.getCategoryId()).orElseThrow(()-> new CategoryException("category bulunamadi")); `

```
2  3  2  5
|  |  |  |_ kacindi hata
|  |  |___ hangi class
|  |______ hangi katman -> controller,service,repo,token vs.
|_________ hangi proje / hangi microservis

```


```

2  3  1 1
|  |  | |_ kacindi hata
|  |  |___ kacindi hata
|  |______ hangi class
|_________ hangi katman -> controller,service,repo,token vs.

```