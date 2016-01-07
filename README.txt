itop-rest-java-client

how to use:
ITopRestClient client = new ITopRestClient("*login*", "*password*", "1.0", "*iTop Rest URL*"); 

JSONObject virtualMachineJson = client.getObjects("*object*", "*key*");

todo:
readme
save
modify
delete

based on:
https://wiki.openitop.org/doku.php?id=advancedtopics:rest_json