
Pod::Spec.new do |s|
  s.name         = "RNSmartassets"
  s.version      = "1.0.1"
  s.summary      = "RNSmartassets"
  s.description  = <<-DESC
                  RNSmartassets
                   DESC
  s.homepage     = "https://github.com/smallnew/RNSmartassets.git"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "7.0"
  s.source       = { :git => "https://github.com/smallnew/RNSmartassets.git", :tag => "master" }
  s.source_files  = "*.{h,m}"
  s.requires_arc = true


  s.dependency "React"
  #s.dependency "others"

end

