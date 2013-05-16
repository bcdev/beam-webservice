beam-webservice
===============

This is a sandbox repository used to investigate into various technologies
enabling a BEAM web-(processing)-service. A BEAM web-service could serve as possibility 
to access the BEAM Java API from other programming languages using a local
server and hereby allowing for elegant inter-process communication. For example, a 
number of Python clients exist for JSON-RPC servers.

The respository includes two submodules (both very experimental):
* `beam-jaxws`: Uses [JAX-WS](http://en.wikipedia.org/wiki/Java_API_for_XML_Web_Services)
* `beam-jsonrcp`: Uses [JSON-RPC](http://en.wikipedia.org/wiki/JSON-RPC) enabled by [Jackson](https://github.com/FasterXML/jackson-core) 



