File androidCommonUtilFile = new File('android-common-util')
if (!androidCommonUtilFile.exists()) {
    Process re = 'git clone https://gitee.com/lj-framework-java/android-common-util.git'.execute(null, new File(path))
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(re.inputStream));
    println '克隆android-common-util  '
    String printStr
    while ((printStr = bufferedReader.readLine()) != null) {
        println printStr
    }
} else {
    String re = 'git pull'.execute(null, androidCommonUtilFile).text.trim()
    println '更新android-common-util完成  ' + re
}

gradle.include ':android-common-util'
gradle.project(':android-common-util').projectDir = androidCommonUtilFile
