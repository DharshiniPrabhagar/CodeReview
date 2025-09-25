const http=require('http')
const port=3000
const server=http.createServer((req,res)=>{
if(req.url=='/hello'){
res.write('hello world')
res.end()
}else if(req.url=='/bye'){
res.write('bye')
res.end()
}else{
res.write('unknown')
res.end()
}
})
server.listen(port)
console.log('server running on port '+port)
