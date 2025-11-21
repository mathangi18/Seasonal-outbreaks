# Validate Environment for AnyLogic Bundle

Write-Host "Checking Environment..."

# 1. Check Images
$imgDir = "..\resources\images"
$images = @("patient_doll.png", "hospital_small.png", "hospital_big.png", "ambulance.png")
$allImagesFound = $true

foreach ($img in $images) {
    if (Test-Path "$imgDir\$img") {
        Write-Host "OK: $img found." -ForegroundColor Green
    } else {
        Write-Host "FAIL: $img NOT found." -ForegroundColor Red
        $allImagesFound = $false
    }
}

# 2. Check JDK
if (Get-Command "javac" -ErrorAction SilentlyContinue) {
    Write-Host "OK: JDK found." -ForegroundColor Green
} else {
    Write-Host "WARNING: JDK (javac) not found in PATH. AnyLogic might still work if it uses its own JDK." -ForegroundColor Yellow
}

# 3. Check Python
if (Get-Command "python" -ErrorAction SilentlyContinue) {
    Write-Host "OK: Python found." -ForegroundColor Green
} else {
    Write-Host "WARNING: Python not found. Test scripts might fail." -ForegroundColor Yellow
}

if ($allImagesFound) {
    Write-Host "Environment Validation PASSED (Images present)." -ForegroundColor Green
} else {
    Write-Host "Environment Validation FAILED (Missing images)." -ForegroundColor Red
}
