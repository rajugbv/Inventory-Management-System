import React, { useEffect, useState } from 'react';

const BarcodeScanner = ({ onScan }) => {
  const [scannedCode, setScannedCode] = useState('');

  useEffect(() => {
    const handleScan = (event) => {
      const code = event.key;
      setScannedCode((prev) => prev + code);
    };

    window.addEventListener('keypress', handleScan);

    return () => {
      window.removeEventListener('keypress', handleScan);
    };
  }, []);

  useEffect(() => {
    if (scannedCode.length >= 13) {
      onScan(scannedCode);
      setScannedCode('');
    }
  }, [scannedCode]);

  return <div>Scanning...</div>;
};

export default BarcodeScanner;
