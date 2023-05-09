File pagingRvFile = new File('paging-rv')
println path
if (!pagingRvFile.exists()) {
    Process re = 'git clone https://gitee.com/lj-framework-java/paging-rv.git'.execute(null, new File(path))
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(re.inputStream))
    println '克隆paging-rv '
    String printStr
    while ((printStr = bufferedReader.readLine()) != null) {
        println printStr
    }
} else {
    String re = 'git pull'.execute(null, pagingRvFile).text.trim()
    println '更新paging-rv完成  ' + re
}

gradle.include ':paging-rv'
gradle.project(':paging-rv').projectDir = pagingRvFile
